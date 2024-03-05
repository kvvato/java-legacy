package org.molgenis.framework.tupletable.view.renderers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.molgenis.framework.tupletable.TableException;
import org.molgenis.framework.tupletable.TupleTable;
import org.molgenis.io.TupleWriter;
import org.molgenis.io.excel.ExcelWriter;
import org.molgenis.util.tuple.Tuple;

/**
 * Export TupleTable to Excel workbook
 */
public class ExcelExporter extends AbstractExporter
{
	public ExcelExporter(TupleTable tableTable)
	{
		super(tableTable);
	}

	@Override
	public void export(OutputStream os) throws TableException
	{
		ExcelWriter excelWriter = new ExcelWriter(os);
		try
		{
			// save table state
			int colOffset = tupleTable.getColOffset();
			int colLimit = tupleTable.getColLimit();
			int rowOffset = tupleTable.getOffset();
			int rowLimit = tupleTable.getLimit();

			// update table state
			tupleTable.setColOffset(0);
			tupleTable.setColLimit(0);
			tupleTable.setOffset(0);
			tupleTable.setLimit(0);

			TupleWriter tupleWriter = excelWriter.createTupleWriter("Sheet1");
			try
			{
				// write header row
				tupleWriter.writeColNames(tupleTable.getColumns().stream()
						.map((f) -> f != null ? f.getName() : null)
						.collect(Collectors.toList()));

				// write rows
				for (Iterator<Tuple> it = tupleTable.iterator(); it.hasNext();)
					tupleWriter.write(it.next());
			}
			finally
			{
				IOUtils.closeQuietly(tupleWriter);

				// restore table state
				tupleTable.setColOffset(colOffset);
				tupleTable.setColLimit(colLimit);
				tupleTable.setOffset(rowOffset);
				tupleTable.setLimit(rowLimit);
			}
		}
		catch (IOException e)
		{
			throw new TableException(e);
		}
		finally
		{
			IOUtils.closeQuietly(excelWriter);
		}
	}
}
