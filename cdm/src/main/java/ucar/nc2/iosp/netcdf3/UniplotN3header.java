package ucar.nc2.iosp.netcdf3;

import java.io.IOException;
import java.util.Formatter;

import com.google.common.base.Charsets;

import ucar.nc2.NetcdfFile;
import ucar.unidata.io.RandomAccessFile;

public class UniplotN3header extends N3header {
  static final byte[] MAGIC = new byte[] { 0x43, 0x44, 0x48, 0x01 };

  static public boolean isValidFile(ucar.unidata.io.RandomAccessFile raf)
      throws IOException {
    // this is the first time we try to read the file - if there's a problem we
    // get an IOException
    raf.seek(0);
    byte[] b = new byte[4];
    raf.readFully(b);
    for (int i = 0; i < 3; i++)
      if (b[i] != MAGIC[i])
        return false;
    return ((b[3] == 1) || (b[3] == 2));
  }

  public UniplotN3header() {
    setValueCharset(Charsets.ISO_8859_1);
  }

  @Override
  protected byte[] getMagic() {
    return MAGIC;
  }

  @Override
  protected int getByteOrder() {
    return RandomAccessFile.LITTLE_ENDIAN;
  }

  @Override
  void create(RandomAccessFile raf, NetcdfFile ncfile, int extra,
      boolean largeFile, Formatter fout) throws IOException {
    throw new UnsupportedOperationException("is currently not supported");
  }
}
