package HW;

import java.util.Objects;

public enum LengthUnit {
	MM(1.), CM(10.), M(1000.0);
	
	private final double mmAmount;

	LengthUnit(double mmAmount) {
		this.mmAmount = mmAmount;
	}

	public double getMmAmount() {
		return mmAmount;
	}
	
	public double convert(LengthUnit other) {
		if(other == null) return 0.0;
		return mmAmount/ other.getMmAmount();
	}

	public int between(Length len1, Length len2) {
		if(Objects.isNull(len1) || Objects.isNull(len2)) return 0;
		return len2.convert(this).getCount() - len1.convert(this).getCount();
	}
}
