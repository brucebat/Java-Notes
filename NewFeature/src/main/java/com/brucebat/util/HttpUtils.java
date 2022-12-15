package com.brucebat.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * http调用工具类
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/11/18 18:04
 */
public class HttpUtils {

    private static final HttpClient HTTP_CLIENT;

    static {
        HTTP_CLIENT = HttpClient.newBuilder().connectTimeout(Duration.of(5, ChronoUnit.SECONDS)).build();
    }

    /**
     * 进行get请求调用
     *
     * @param url 待调用请求地址
     * @return 调用完成请求结果
     */
    public static String doGet(String url) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        try {
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 进行post请求调用
     *
     * @param url    待调用请求地址
     * @param params 请求参数
     * @return 返回结果
     */
    public static String doPost(String url, String params) {

        return null;
    }
}
