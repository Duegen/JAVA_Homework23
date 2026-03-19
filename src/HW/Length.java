package HW;

import java.util.Objects;

public class Length {
	
	private final int count;
	private final LengthUnit unit;
	
	public Length(int count, LengthUnit mmAmount) {	
		if(count < 0)
			throw new IllegalArgumentException("count is less then zero");
		else	
			this.count = count; 
		if(Objects.isNull(mmAmount))
			throw new IllegalArgumentException("enum is null");
		else
			this.unit = mmAmount;
	}
	
	public int getCount() {
		return count;
	}

	public LengthUnit getMmAmount() {
		return unit;
	}

	@Override
	public String toString() {
		return "" + count + unit;
	}

	public Length plus(Length other) {
		if(Objects.isNull(other))
			throw new IllegalArgumentException("object is null");
		return new Length (Math.addExact(count, convertToThis(other)), unit);
	}

	public Length minus(Length other) {
		if(Objects.isNull(other))
			throw new IllegalArgumentException("object is null");
		return new Length (Math.abs(count - convertToThis(other)), unit);
	}

	private int convertToThis(Length other) {
		return (int)Math.round(other.count * (other.unit.convert(unit)));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(count, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Length other = (Length) obj;
		return count * unit.getMmAmount() == other.count * other.unit.getMmAmount();
	}

	public Length convert(LengthUnit convertTo) {
		if(Objects.isNull(convertTo))
			return this;
		return new Length((int)(count * unit.convert(convertTo)), convertTo);
	}
}
