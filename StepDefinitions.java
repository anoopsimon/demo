package io.cucumber.skeleton;

//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) throws IOException, InterruptedException {
//        Belly belly = new Belly();
//        belly.eat(cukes);
//        //CustomReportListener.log(Status.PASS,"Let me ge this");

        String dll="C:\\Users\\s4514\\Downloads\\jacob-1.16.1\\jacob-1.16.1\\jacob-1.16.1-x64.dll";
        //String dll="C:\\Users\\s4514\\AppData\\Local\\Temp\\jacob-1.20-x64.dll";
        WindowsRegistry.importSilently("C:\\Users\\s4514\\AppData\\Local\\Temp\\AutoItX3_x64.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH,dll);
        AutoItX x = new AutoItX();
        String notepad = "Untitled - Notepad";
        String testString = "this is a test.";
        x.run("notepad.exe");
        x.winActivate(notepad);
        x.winWaitActive(notepad);
        x.send(testString);
        //assertTrue(x.winExists(notepad, testString));
        x.winClose(notepad, testString);
        x.winWaitActive("Notepad");
        x.send("{ALT}n");
        assertFalse(x.winExists(notepad, testString));
    }

    @Given("I have {int} cukes in my head")
    public void I_have_cukes_in_my_head(int cukes) {
        Belly belly = new Belly();
        belly.eat(cukes);
        //CustomReportListener.log(Status.INFO,"Let me ge this correct");
        //CustomReportListener.attachScreenshot(Status.INFO,"Let me ge this correct");

    }

    @When("I wait {int} hour")
    public void iWaitHour(int arg0) {
        String x = System.getProperty("env");
        System.out.println("Selected Environment is :  "  + x);
        //CustomReportListener.log(Status.PASS,"------------" + x);

    }

    @Then("my belly should growl")
    public void myBellyShouldGrowl() {
        //CustomReportListener.log(Status.PASS,"Let me ge this correctly");


    }
}
