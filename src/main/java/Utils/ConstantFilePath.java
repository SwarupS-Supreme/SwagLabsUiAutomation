package Utils;

import Enums.PropertyEnum;

public final class ConstantFilePath {
    private ConstantFilePath() {

    }

    private static final String PATHTORESOURCES = System.getProperty("user.dir") + "/src/test/resources";
    private static final String PROPERTYUTILSPATH = PATHTORESOURCES + "/ConfigFiles/FrameworkProperties.properties";
    private static final String REPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-report/";
    private static final String EXCELFILEPATH = System.getProperty("user.dir") + "/src/test/resources/ExternalDataFiles/SwagLabsExcel.xlsx";

    private static String REPORTPATH = "";


    public static String getExcelfilepath()
    {
        return EXCELFILEPATH;
    }

    public static String getPathtoresources() {
        return PROPERTYUTILSPATH;
    }

    public static String getReportpath() {
        if (REPORTPATH.isEmpty()) {
            REPORTPATH = createReportPath();
        }
        return REPORTPATH;

    }

    private static String createReportPath() {
        if (PropertyUtils.get(PropertyEnum.OVERRIDEREPORT.toString().toLowerCase()).equalsIgnoreCase("yes")) {
            return REPORTFOLDERPATH + "index.html";
        } else {
            return REPORTFOLDERPATH + System.currentTimeMillis() + "index.html";
        }
    }


}
