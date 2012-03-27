import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class CircularArrayList<E> extends AbstractList<E> 
		implements List<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = -4886139346193901717L;

	private transient Object[] elementData;

	private int size;

	private int head;

	private int tail;

	public CircularArrayList(int initialCapacity) {
		super();
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
		head = tail = 0;
		elementData = new Object[initialCapacity];
	}

	public CircularArrayList() {
		this(10);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(E e) {
		ensureCapacity(size + 1);
		elementData[tail++] = e;
		size++;
		return true;
	}

	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;

		if (minCapacity > oldCapacity) {
			Object[] oldData = elementData;
			int newCapacity = (oldCapacity * 3)/2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = new Object[newCapacity];
			System.arraycopy(oldData, 0, elementData, 0, tail);
			System.arraycopy(oldData, tail, elementData, elementData.length + head, -head);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public E get(int index) {
		index = ((elementData.length + head) + index) % elementData.length;
		return (E) elementData[index];
	}

}

