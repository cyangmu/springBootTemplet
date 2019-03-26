package com.cyj.spring.common.utils.comment;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author:cyj
 * @data:2017/12/20 17:38
 * @describe:
 */
public class MyX509TrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] arg0, String arg1)
            throws CertificateException {


    }


    @Override
    public void checkServerTrusted(X509Certificate[] arg0, String arg1)
            throws CertificateException {


    }


    @Override
    public X509Certificate[] getAcceptedIssuers() {

        return null;
    }

}
