package tools;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Excel {
	private static Logger logger = Logger.getLogger(Excel.class);
		private static org.apache.poi.ss.usermodel.Workbook wb;
		// private InputStream stream = null;
		private String filename;
		private static File file = null;

		/**
		 * 
		 * @param sheetname
		 * @throws IOException 
		 */
		private void addSheet(final String sheetname) throws IOException {
			
				final InputStream stream = new FileInputStream(filename);
				if (!isXlsx()) {
					wb = new HSSFWorkbook(stream);
				} else {
					wb = new XSSFWorkbook(stream);
				}
				wb.createSheet(sheetname);
				stream.close();
			
			OutputStream outstream = null;

			try {

				outstream = new FileOutputStream(filename);

				wb.write(outstream);
			} catch (final IOException e) {

				throw new IOException();
			} finally {
				if (outstream != null) {
					try {
						outstream.close();
					} catch (final IOException e) {

						e.printStackTrace();
					}
				}
			}

		}

		/**
		 * 
		 * @return
		 */
		private	boolean isXlsx() {
			boolean isE2007 = false; // 判断是否是excel2007格式
			if (filename.endsWith("xlsx")) {
				isE2007 = true;
			}
			return isE2007;
		}

		/**
		 * 
		 * 
		 * @param filename
		 * @throws IOException 
		 */
		public Excel openExcel(final String filename) throws IOException {
			this.filename = filename;
			file = new File(filename);

			if (!file.exists()) {
			
					file.createNewFile();
					write2new("sheet1", 1, 1, "");
				
			}

			return this;

		}

	
//		public String read(final int sheetnum, final int rownum, final int cellnum)
//				throws IOException {
//
//			final InputStream stream = new FileInputStream(filename);
//			if (!isXlsx()) {
//				wb = new HSSFWorkbook(stream);
//			} else {
//				wb = new XSSFWorkbook(stream);
//			}
//			final Sheet sheet = wb.getSheetAt(sheetnum - 1);
//			final String[][] res = new String[sheet.getLastRowNum() + 1][];
//			// List<String> rowvalue=new ArrayList<String>();
//			// System.out.println(sheet.getLastRowNum() + 1);
//			// final int i = 0;
//			for (final Row row : sheet) {
//				// System.out.println(row.getRowNum());
//				res[row.getRowNum()] = new String[row.getLastCellNum()];
//
//				// System.out.println(Arrays.toString(res[0]) + "!");
//
//				for (final Cell cell : row) {
//					// System.out.println(cell.getRowIndex() + 1 + ":"
//					// + (cell.getColumnIndex() + 1) + "=" +
//					// cell.getStringCellValue()
//					// + "   ");
//					// System.out.println(res[cell.getRowIndex()].length + "??");
//					res[cell.getRowIndex()][cell.getColumnIndex()] = cell
//							.getStringCellValue();
//					// System.out.println("shishi");
//
//				}
//				// System.out.println(Arrays.toString(res));
//
//			}
//			// for (final String[] re : res) {
//			// System.out.println(Arrays.toString(re));
//			// }
//			stream.close();
//			return res[rownum - 1][cellnum - 1];
//		}

		/**
		 * 
		 * @param sheetname
		 * @return
		 * @throws IOException
		 */
		public Map<Point, String> read(final String sheetname) throws IOException {

			final InputStream stream = new FileInputStream(filename);
			if (!isXlsx()) {
				wb = new HSSFWorkbook(stream);
			} else {
				wb = new XSSFWorkbook(stream);
			}
			// System.out.println(wb.toString() + ":" + filename + ":" + sheetname);
			final Sheet sheet = wb.getSheet(sheetname);
			// System.out.println(sheet.toString());
			
			Map<Point, String> map=new HashMap<Point, String>();
			//final String[][] res = new String[sheet.getPhysicalNumberOfRows()][];
			//logger.debug(sheet.getPhysicalNumberOfRows());
			// List<String> rowvalue=new ArrayList<String>();
			//int i = 0;
			for (final Row row : sheet) {
				//logger.debug(row.getRowNum());
				//res[row.getRowNum()] = new String[row.getLastCellNum()];
				// System.out.println(row.getPhysicalNumberOfCells());
				//i++;
				for (final Cell cell : row) {
					cell.setCellType(Cell.CELL_TYPE_STRING);// 设置输出格式
					map.put(new Point(cell.getRowIndex()+1, cell.getColumnIndex()+1), cell
							.getStringCellValue());
//					res[cell.getRowIndex()][cell.getColumnIndex()] = cell
//							.getStringCellValue();
//					logger.debug("getRowNum:"+row.getRowNum()+"cell.getRowIndex():"+cell.getRowIndex()+"cell.getColumnIndex():"+cell.getColumnIndex()
//							+"cell.getStringCellValue()"+cell
//						.getStringCellValue()+"\n");
				}
				// System.out.println(Arrays.toString(res));

				// String[][] aa = res;
				// aa = null;

			}

			stream.close();
			return map;
		}

		/**
		 * 
		 * @param sheetname
		 * @param rownum
		 * @param cellnum
		 * @return
		 * @throws IOException
		 */
		public String read(final String sheetname, final int rownum,
				final int cellnum) throws IOException {
			return read(sheetname).get(new Point(rownum,cellnum));
			
			 }

		/**
		 * 
		 * @param sheetname
		 * @param rownum
		 * @param cellnum
		 * @param value
		 * @param args
		 *            超链接格式l!linkPath 颜色格式要 c!coloer 颜色有: AQUA
		 * 
		 *            AUTOMATIC
		 * 
		 *            BLACK
		 * 
		 *            BLUE
		 * 
		 *            BLUE_GREY
		 * 
		 *            BRIGHT_GREEN
		 * 
		 *            BROWN
		 * 
		 *            CORAL
		 * 
		 *            CORNFLOWER_BLUE
		 * 
		 *            DARK_BLUE
		 * 
		 *            DARK_GREEN
		 * 
		 *            DARK_RED
		 * 
		 *            DARK_TEAL
		 * 
		 *            DARK_YELLOW
		 * 
		 *            GOLD
		 * 
		 *            GREEN
		 * 
		 *            GREY_25_PERCENT
		 * 
		 *            GREY_40_PERCENT
		 * 
		 *            GREY_50_PERCENT
		 * 
		 *            GREY_80_PERCENT
		 * 
		 *            INDIGO
		 * 
		 *            LAVENDER
		 * 
		 *            LEMON_CHIFFON
		 * 
		 *            LIGHT_BLUE
		 * 
		 *            LIGHT_CORNFLOWER_BLUE
		 * 
		 *            LIGHT_GREEN
		 * 
		 *            LIGHT_ORANGE
		 * 
		 *            LIGHT_TURQUOISE
		 * 
		 *            LIGHT_YELLOW
		 * 
		 *            LIME
		 * 
		 *            MAROON
		 * 
		 *            OLIVE_GREEN
		 * 
		 *            ORANGE
		 * 
		 *            ORCHID
		 * 
		 *            PALE_BLUE
		 * 
		 *            PINK
		 * 
		 *            PLUM
		 * 
		 *            RED
		 * 
		 *            ROSE
		 * 
		 *            ROYAL_BLUE
		 * 
		 *            SEA_GREEN
		 * 
		 *            SKY_BLUE
		 * 
		 *            TAN
		 * 
		 *            TEAL
		 * 
		 *            TURQUOISE
		 * 
		 *            VIOLET
		 * 
		 *            WHITE
		 * 
		 *            YELLOW
		 * 
		 * @throws IOException
		 */
		public void writeOne(final String sheetname, final int rownum,
				final int cellnum, final String value, final String... args)
				throws IOException {
			String color = null;
			String linkPath = null;
			//判断文件类型
			InputStream stream = null;
			try {
				stream = new FileInputStream(filename);
				if (!isXlsx()) {
					wb = new HSSFWorkbook(stream);
				} else {
					wb = new XSSFWorkbook(stream);
				}
				CellStyle cs = null;
				org.apache.poi.ss.usermodel.Hyperlink link = null;
				
//				设置超链接和背景色
				if (args.length != 0) {
					for (final String ele : args) {
						switch (ele.charAt(0)) {
						case 'c':
							color = ele.split("!")[1];
							break;
						case 'l':
							linkPath = ele.split("!")[1];
							break;
						default:
							logger.warn("传入信息错误:" + Arrays.toString(args));
						}
					}
					cs = wb.createCellStyle();
					if (color != null) {
						cs.setFillForegroundColor(IndexedColors.valueOf(color).index);// 设置颜色
						cs.setFillPattern(CellStyle.SOLID_FOREGROUND);// 设置填充方式
						// cs.setAlignment(CellStyle.ALIGN_CENTER);设置水平位置
						// cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);设置垂直位置
					}
				}
				if (linkPath != null) {
					if (!isXlsx()) {
						link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
					} else {
						link = wb.getCreationHelper().createHyperlink(
								Hyperlink.LINK_URL);
					}
				}
				//已经设置好颜色和超链接
				//开始写数据//
				Sheet sheet = wb.getSheet(sheetname);
				Row row;
				try {
					row = sheet.getRow(rownum - 1);
				} catch (final NullPointerException e1) {

					sheet = wb.createSheet(sheetname);
					row = sheet.createRow(rownum - 1);
				}
				Cell cell;
				try {
					cell = row.createCell(cellnum - 1);
				} catch (final NullPointerException e) {
					//
					// e.printStackTrace();
					row = sheet.createRow(rownum - 1);
					cell = row.createCell(cellnum - 1);
				}
				cell.setCellValue(value);
				if (cs != null) {
					cell.setCellStyle(cs);
				}
				if (link != null) {
					link.setAddress(linkPath);
					cell.setHyperlink(link);// 设定单元格的链接
				}
			} catch (final IOException e) {
				//
			throw new IOException();
			} finally {
				try {
					if (stream != null) {
						stream.close();
					}
				} catch (final IOException e) {
					//
					e.printStackTrace();
				}
			}

			OutputStream outstream = null;
			try {
				outstream = new FileOutputStream(filename);
				
					try {
						wb.removeSheetAt(wb.getSheetIndex("sheet1"));
					} catch (final IllegalArgumentException e) {

					}
					
				
			
			} finally {
				wb.write(outstream);
				try {
					if (outstream != null) {
						outstream.close();
					}
				} catch (final IOException e) {
					
				}
			}

		}

		/**
		 * 
		 * @param sheetname
		 *            表名 从1开始计数
		 * @param rownum
		 *            行号,从1开始计数
		 * 
		 * @param cellnum
		 *            单元格号,从1开始计数
		 * @throws IOException
		 * 
		 */

		private	void write2new(final String sheetname, final int rownum, final int cellnum,
				final String value) throws IOException {
			if (!isXlsx()) {
				wb = new HSSFWorkbook();
			} else {
				wb = new XSSFWorkbook();
			}
			final Sheet sheet = wb.createSheet(sheetname);

			final Row row = sheet.createRow(rownum - 1);
			final Cell cell = row.createCell(cellnum - 1);
			cell.setCellValue(value);
			OutputStream outstream = null;
			try {
				outstream = new FileOutputStream(filename);
				// 写入数据
				wb.write(outstream);
			} catch (final IOException e) {
				//
				throw new IOException();
			} finally { // 关闭文件流
				try {
					outstream.close();
				} catch (final IOException e) {
					
				}
			}

		}
		public void write2all(final String sheetname, Map<Point, String> map)
				throws IOException {
			InputStream stream = null;
			try {
				stream = new FileInputStream(filename);
				if (!isXlsx()) {
					wb = new HSSFWorkbook(stream);
				} else {
					wb = new XSSFWorkbook(stream);
				}
				Sheet sheet = wb.getSheet(sheetname);
				Row row;
				Cell cell;
				if(map.size()>0){
					for (Entry<Point, String> entry : map.entrySet()) {
						try {
							row = sheet.getRow(entry.getKey().x - 1);
						} catch (final NullPointerException e1) {

							sheet = wb.createSheet(sheetname);
							row = sheet.createRow(entry.getKey().x - 1);
						}
						//
						try {
							cell = row.createCell(entry.getKey().y - 1);
						} catch (final NullPointerException e) {
							//
							// e.printStackTrace();
							row = sheet.createRow(entry.getKey().x - 1);
							cell = row.createCell(entry.getKey().y - 1);
						}
						//
						cell.setCellValue(entry.getValue());
					}
				}
				
				
				
				
			
			} catch (final IOException e) {
				//
			throw new IOException();
			} finally {
				try {
					if (stream != null) {
						stream.close();
					}
				} catch (final IOException e) {
					//
					e.printStackTrace();
				}
			}

			OutputStream outstream = null;
			try {
				outstream = new FileOutputStream(filename);
				
					try {
						wb.removeSheetAt(wb.getSheetIndex("sheet1"));
					} catch (final IllegalArgumentException e) {

					}
					
				
			
			} finally {
				wb.write(outstream);
				try {
					if (outstream != null) {
						outstream.close();
					}
				} catch (final IOException e) {
					
				}
			}

			
		}
}
