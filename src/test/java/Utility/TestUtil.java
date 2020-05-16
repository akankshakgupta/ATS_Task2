package Utility;


import java.util.ArrayList;



public class TestUtil {


    static Xls_Reader reader;

    public static   ArrayList<Object[]> getDataFromExcel()
    {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try
        {
            reader = new Xls_Reader(System.getProperty("user.dir")+"/Excel/TRF.xlsx");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //get data from excel
        for (int rowNum =2; rowNum<=reader.getRowCount("TRFData"); rowNum++)

        {


            // read value from ctc column
            String ctc = reader.getCellData("TRFData", "CTC", rowNum);

            // read value from vacancy column
            String vacancy = reader.getCellData("TRFData", "Vacancy", rowNum);


            //read value from mandatory_skill column
            String mandatory_skills = reader.getCellData("TRFData", "Mandatory_Skills", rowNum);

            // read value from skill column
            String  skills = reader.getCellData("TRFData", "Skills", rowNum);


            // read value from responsibility column
            String responsiblity = reader.getCellData("TRFData", "Responsiblities", rowNum);

            // read value from reporting manager column
            String rm = reader.getCellData("TRFData", "Reporting_Manager", rowNum);

            // read value from experience column
            String exp = reader.getCellData("TRFData", "Experience", rowNum);

            // read value from traits column
            String traits = reader.getCellData("TRFData", "Traits", rowNum);

            // read value from authorize column
            String authorize = reader.getCellData("TRFData", "Authorized_By", rowNum);



            Object ob[] = { ctc , vacancy ,mandatory_skills,skills , responsiblity,rm,exp,traits,authorize };
            myData.add(ob);



        }
        return myData;


    }

}
