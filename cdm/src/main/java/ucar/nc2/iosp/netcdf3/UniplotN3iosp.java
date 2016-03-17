package ucar.nc2.iosp.netcdf3;

import java.io.IOException;

import ucar.nc2.constants.DataFormatType;
import ucar.unidata.io.RandomAccessFile;

public class UniplotN3iosp extends N3raf {

  public UniplotN3iosp() {
  }

  @Override
  protected N3header newHeader() {
    return new UniplotN3header();
  }
  
  @Override
  public boolean isValidFile(RandomAccessFile raf) throws IOException {
    return UniplotN3header.isValidFile(raf);
  }

  @Override
  public String getFileTypeId() {
    return DataFormatType.NETCDH.getDescription();
  }

  @Override
  public String getFileTypeDescription() {
    return "NetCDF-3/Uniplot";
  }
}
