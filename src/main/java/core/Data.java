package core;
import org.testng.annotations.DataProvider;
public class Data {

    @DataProvider(name = "addedUsers")
    public Object[][] addedUsers() {
        return new Object[][]{
                {"Test Automated","test1@yopmail.com"},
                {"Test Automated 2","test2@yopmail.com"}
        };
    }
}
