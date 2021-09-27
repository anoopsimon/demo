package io.cucumber.skeleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsRegistry
{
    public static void importSilently(String regFilePath) throws IOException,
            InterruptedException
    {
        if (!new File(regFilePath).exists())
        {
            throw new FileNotFoundException();
        }

        String command = "powershell.exe regsvr32 \"" + regFilePath + "\" /s";
        System.out.println(command);
        Process importer = Runtime.getRuntime().exec(command);


        importer.waitFor();
    }

    public static void overwriteValue(String keyPath, String keyName,
                                      String keyValue) throws IOException, InterruptedException
    {
        Process overwriter = Runtime.getRuntime().exec(
                "reg add " + keyPath + " /t REG_SZ /v \"" + keyName + "\" /d "
                        + keyValue + " /f");

        overwriter.waitFor();
    }

    public static String getValue(String keyPath, String keyName)
            throws IOException, InterruptedException
    {
        Process keyReader = Runtime.getRuntime().exec(
                "reg query \"" + keyPath + "\" /v \"" + keyName + "\"");

        BufferedReader outputReader;
        String readLine;
        StringBuffer outputBuffer = new StringBuffer();

        outputReader = new BufferedReader(new InputStreamReader(
                keyReader.getInputStream()));

        while ((readLine = outputReader.readLine()) != null)
        {
            outputBuffer.append(readLine);
        }

        String[] outputComponents = outputBuffer.toString().split("    ");

        keyReader.waitFor();

        return outputComponents[outputComponents.length - 1];
    }
}