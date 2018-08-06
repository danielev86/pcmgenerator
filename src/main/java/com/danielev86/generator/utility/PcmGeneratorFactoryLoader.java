package com.danielev86.generator.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielev86.generator.bean.CyclistBean;

@Component
public class PcmGeneratorFactoryLoader {

	@Autowired
	private  GenericCsvReader csvReader;

	public  List<CyclistBean> loadCyclistData(String path, String split) throws IOException {
		List<CyclistBean> lstResult = new ArrayList<>();
		List<Object[]> lstObj = csvReader.readCsvFile(path, split);

		if (CollectionUtils.isNotEmpty(lstObj)) {

			for (Object[] record : lstObj) {
				CyclistBean cyclist = new CyclistBean();
				cyclist.setLastName(record[0].toString().replaceAll("\"", ""));
				cyclist.setFirstName(record[1].toString().replaceAll("\"", ""));
				cyclist.setCharacPlan(Integer.valueOf(record[2].toString()));
				cyclist.setCharacMountain(Integer.valueOf(record[3].toString()));
				cyclist.setCharacDownHilling(  Integer.valueOf(  record[4].toString() )   );
				cyclist.setCharacCobble(  Integer.valueOf( record[5].toString() ) );
				cyclist.setCharacTimetrial( Integer.valueOf(record[6].toString()) );
				cyclist.setCharacPrologue(  Integer.valueOf(record[7].toString()) );
				cyclist.setCharacSprint( Integer.valueOf( record[8].toString() ) );
				cyclist.setCharacAcceleration(  Integer.valueOf( record[9].toString() ) );
				cyclist.setCharacEndurance( Integer.valueOf( record[10].toString() ) );
				cyclist.setCharacResistance( Integer.valueOf( record[11].toString() ) );
				cyclist.setCharacRecuperation( Integer.valueOf( record[12].toString() ) );
				cyclist.setCharacHill( Integer.valueOf( record[13].toString() ) );
				cyclist.setCharacBaroudeur( Integer.valueOf( record[14].toString() ) );
				
				lstResult.add(cyclist);
				
			}

		}

		return lstResult;
	}

}
