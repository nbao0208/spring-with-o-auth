package org.example.applicationwithoauth.config;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CacheHttpServletRequest extends HttpServletRequestWrapper {
  private byte[] cacheBody;

  public CacheHttpServletRequest(HttpServletRequest request) throws IOException {
    super(request);
    InputStream inputStream = request.getInputStream();
    //copy all the byte stream of the input stream from the request to the byte array
    //after copy, the input stream of the request will null
    //we have already backed up this data to cacheBody
    this.cacheBody = StreamUtils.copyToByteArray(inputStream);
  }

  public String getRequestBody() throws IOException {
    //create input stream to read from the byte array name cache body
    InputStream inputStream = new ByteArrayInputStream(cacheBody);
    //create byte output stream to write info
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int readBytes = 0;
    while ((readBytes = inputStream.read(buffer)) != -1) {
      byteArrayOutputStream.write(buffer, 0, readBytes);
    }
    return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    //because the flowing need this method to read the request
    return new CacheServletInputStream(cacheBody);
  }
}
