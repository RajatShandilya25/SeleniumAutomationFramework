package Utility;

public final class FrameworkConstants
{
    private FrameworkConstants() {}

    private static final String CONFIG_FILE_PATH = "/Users/praveensharma/IdeaProjects/SeleniumAutomationFramework/src/main/resources/Config.properties";

    public static String getConfigFilePath()
    {
        return CONFIG_FILE_PATH;
    }


}
