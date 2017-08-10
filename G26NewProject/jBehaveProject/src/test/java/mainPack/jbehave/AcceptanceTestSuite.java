package mainPack.jbehave;

import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
	public AcceptanceTestSuite() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspaceG26\\G26NewProject\\G26NewProject\\drivers\\chromedriver.exe");
		findStoriesCalled("**/*.story");
	}
}
