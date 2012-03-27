import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class CircularArrayList<E> extends AbstractList<E> 
		implements List<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = -4886139346193901717L;

	public CircularArrayList() {
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public E get(int index) {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}

