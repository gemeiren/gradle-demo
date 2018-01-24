package javaBase.streaming;

import java.util.List;


public class IbatisRangeFactory {
	
	private IbatisRange ibatisRange;

	private IbatisRangeFactory(IbatisRange newIbatisRange) {
		this.ibatisRange = newIbatisRange;
	}

	//Get an object
	public static IbatisRangeFactory newIbatisRange() {
		return new IbatisRangeFactory(new IbatisRange());
	}

	public IbatisRangeFactory inContent(List<String> inContent) {
		ibatisRange.setInContent(inContent);
		return this;
	}
	
	public IbatisRangeFactory outContent(List<String> outContent){
		ibatisRange.setOutContent(outContent);
		return this;
	}
	
	public IbatisRangeFactory greater(String greater){
		ibatisRange.setGreater(greater);
		return this;
	}
	
	public IbatisRangeFactory less(String less){
		ibatisRange.setLess(less);
		return this;
	}
	
	public IbatisRangeFactory greaterEqual(boolean greaterEqual){
		ibatisRange.setGreaterEqual(greaterEqual);
		return this;
	}
	
	public IbatisRangeFactory lessEqual(boolean lessEqual){
		ibatisRange.setLessEqual(lessEqual);
		return this;
	}
	
	public static IbatisRange assignValue(IbatisRange source){
		IbatisRange result = new IbatisRange();
		result.setGreater(source.getGreater());
		result.setGreaterEqual(source.getGreaterEqual());
		result.setLess(source.getLess());
		result.setLessEqual(source.getLessEqual());
		
		result.setOutContent(source.getOutContent());
		result.setInContent(source.getInContent());
		return result;
	}
	
	public IbatisRange build(){
		return assignValue(ibatisRange);
	}
}
