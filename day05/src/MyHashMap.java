import java.util.*;

/**
 * Implementation of a HashMap using a collection of MyLinearMap and
 * resizing when there are too many or too few entries.
 *
 * @author downey
 * @param <K>
 * @param <V>
 *
 */
public class MyHashMap<K, V> implements Map<K, V> {

	// average number of entries per map before we grow the map
	private static final double ALPHA = 2.0;
	// average number of entries per map before we shrink the map
	private static final double BETA = 0.5;

	// resizing factor: (new size) = (old size) * (resize factor)
	private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

	private static final int MIN_MAPS = 16;

	// list of maps
	protected List<MyLinearMap<K,V>> maps;
	private int size = 0;

	public MyHashMap() {
		makeMaps(MIN_MAPS);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO: Complete this method
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO: Complete this method
		return false;
	}

	@Override
	public V get(Object key) {
		MyLinearMap<K,V> m = chooseMap(key);
		return m.get(key);
	}

	@Override
	public V put(K key, V value) {
		// TODO: Complete this method
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO: Complete this method
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	protected void rehash(double growthFactor) {
		// TODO: Implement this method
	}

	/**
	 * Initialize maps
	 */
	protected void makeMaps(int size) {
		// TODO: Implement this method
	}

	public void clear() {
		for (int i=0; i<maps.size(); i++) {
			maps.get(i).clear();
		}
		size = 0;
	}

	protected MyLinearMap<K, V> chooseMap(Object key) {
		// TODO: Implement this method
		return null;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.keySet());
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Set<V> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.values());
		}
		return set;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.getEntries());
		}
		return set;
	}
}
