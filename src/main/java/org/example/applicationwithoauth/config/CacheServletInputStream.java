package org.example.applicationwithoauth.config;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CacheServletInputStream extends ServletInputStream {
  private InputStream cacheBodyInputStream;

  public CacheServletInputStream(byte[] cacheBody) {
    //fill request with cache data
    this.cacheBodyInputStream = new ByteArrayInputStream(cacheBody);
  }

  @Override
  public boolean isFinished() {
    try {
      return cacheBodyInputStream.available() == 0;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean isReady() {
    return true;
  }

  @Override
  public void setReadListener(ReadListener readListener) {

  }

  @Override
  public int read() throws IOException {
    return cacheBodyInputStream.read();
  }
}
