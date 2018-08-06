package com.danielev86.generator.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielev86.generator.backend.CyclistManager;
import com.danielev86.generator.bean.CyclistBean;
import com.danielev86.generator.utility.EnviromentPropertyReader;
import com.danielev86.generator.utility.GenericWriter;
import com.danielev86.generator.utility.PcmGeneratorFactoryLoader;

@Component
public class CyclistService {

	public static final String WHITE_SPACE = " ";

	public static final String COMMA = ",";

	@Autowired
	private EnviromentPropertyReader env;
	
	@Autowired
	private GenericWriter writer;
	
	@Autowired
	private PcmGeneratorFactoryLoader pcmGeneratorFactory;
	
	@Autowired
	private CyclistManager cyclistManager;

	public List<String> queryCyclistUpdateGenerator(String inPath, String outPath, String split) throws IOException {
		List<String> lstResult = new ArrayList<>();
		List<CyclistBean> lstCyclist = pcmGeneratorFactory.loadCyclistData(inPath, split);

		if (CollectionUtils.isNotEmpty(lstCyclist)) {
			for (CyclistBean cyclist : lstCyclist) {

				StringBuffer sqlQuery = new StringBuffer();

				sqlQuery.append(" UPDATE DYN_Cyclist ").append(WHITE_SPACE + "SET" + WHITE_SPACE)
						.append(WHITE_SPACE + env.getFieldCharacPlain() + "=" + cyclist.getCharacPlan() + COMMA)
						.append(WHITE_SPACE + env.getFieldCharacMountain() + "=" + cyclist.getCharacMountain() + COMMA)
						.append(WHITE_SPACE + env.getFieldCharacDownHilling() + "=" + cyclist.getCharacDownHilling()
								+ COMMA)
						.append(WHITE_SPACE + env.getFieldCharacCobble() + "=" + cyclist.getCharacCobble() + COMMA)
						.append(WHITE_SPACE + env.getFieldCharacTimetrial() + "=" + cyclist.getCharacTimetrial()
								+ COMMA)
						.append(WHITE_SPACE + env.getFieldCharacPrologue() + "=" + cyclist.getCharacPrologue() + COMMA)
						.append(WHITE_SPACE + env.getFieldCharacSprint() + "=" + cyclist.getCharacSprint() + COMMA)
						.append(WHITE_SPACE + env.getFieldCharacAcceleration() + "=" + cyclist.getCharacAcceleration()
								+ COMMA)
						.append(WHITE_SPACE + env.getFieldCharacEndurance() + "=" + cyclist.getCharacEndurance()
								+ COMMA)
						.append(WHITE_SPACE + env.getFieldCharacResistance() + "=" + cyclist.getCharacResistance()
								+ COMMA)
						.append(WHITE_SPACE + env.getFieldCharacRecuperation() + "=" + cyclist.getCharacRecuperation()
								+ COMMA)
						.append(WHITE_SPACE + env.getFieldCharacHill() + "=" + cyclist.getCharacHill() + COMMA)
						.append(WHITE_SPACE + env.getFieldCharacBarouder() + "=" + cyclist.getCharacBaroudeur()
								+ WHITE_SPACE)
						.append(WHITE_SPACE + "WHERE" + WHITE_SPACE)
						.append(WHITE_SPACE + env.getFieldLastName() + "='" + cyclist.getLastName() + "' AND "
								+ env.getFieldFirstName() + "='" + cyclist.getFirstName() + "'; ");

				lstResult.add(sqlQuery.toString());

			}
		}

		return lstResult;
	}
	
	public void updateCyclist(String inPath, String outPath, String split) throws IOException {
		
		List<String> queries = queryCyclistUpdateGenerator(inPath, outPath, split);
		for (String query:queries) {
			System.out.println(query);
			cyclistManager.updateCyclistInfo(query);
		}
		
	}

}
