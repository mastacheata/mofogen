package com.android.forge.contacts2;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;

import com.android.forge.DataGenerator;
import com.android.forge.contacts2.auto._Calls;
import com.android.forge.randomnames.Fakenames;

public class Calls extends _Calls {

	private static final long serialVersionUID = 1L;

	public void generate() {
		Random rnd = new Random();
		
		this.setDuration(rnd.nextInt(7200));
		this.setDate(DataGenerator.startDate + (long)(rnd.nextDouble() * (DataGenerator.endDate-DataGenerator.startDate)));
		this.setType(rnd.nextInt(2) + 1);
		this.setNew(rnd.nextInt(1));
		
		Expression randomQualifier = ExpressionFactory.matchExp("id", rnd.nextInt(500));
		SelectQuery selectRandomName = new SelectQuery(Fakenames.class, randomQualifier);
		List randomNames = DataGenerator.context.performQuery(selectRandomName);
		Fakenames randomName = (Fakenames) randomNames.get(0);
		
		this.setNumber(randomName.getTelephonenumber());
		
		Expression typeIsPhone = ExpressionFactory.matchExp("toData.toMimetypes", 5);
		Expression isNumber = ExpressionFactory.matchExp("toData.data1", this.getNumber());
		Expression combinedQualifier = typeIsPhone.andExp(isNumber);
		SelectQuery getNameAndType = new SelectQuery(RawContacts.class, combinedQualifier);
		List numbers = DataGenerator.context.performQuery(getNameAndType);
		
		this.setNumbertype(0);
		this.setCsTimestamp(0);
		this.setCsLocalUuid(UUID.randomUUID().toString());
	}
}