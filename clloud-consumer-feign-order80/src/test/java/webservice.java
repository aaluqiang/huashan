import cn.hutool.http.webservice.SoapClient;

import java.util.HashMap;

public class webservice {
    public static void main(String[] args) {
        String address="http://10.71.66.214/PresellFundManageService/PresellFundManage.asmx";
        SoapClient client= SoapClient.create(address);

    }
}

