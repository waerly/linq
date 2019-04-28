package com.bestvike.linq.adapter.enumerable;

import com.bestvike.collections.generic.IList;
import com.bestvike.linq.IEnumerator;
import com.bestvike.linq.adapter.enumerator.FloatArrayEnumerator;
import com.bestvike.linq.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by 许崇雷 on 2019-04-16.
 */
public final class FloatArrayEnumerable implements IList<Float> {
    private final float[] source;

    public FloatArrayEnumerable(float[] source) {
        this.source = source;
    }

    @Override
    public IEnumerator<Float> enumerator() {
        return new FloatArrayEnumerator(this.source);
    }

    @Override
    public Float get(int index) {
        return this.source[index];
    }

    @Override
    public Collection<Float> getCollection() {
        return ArrayUtils.toCollection(this._toArray());
    }

    @Override
    public int _getCount() {
        return this.source.length;
    }

    @Override
    public boolean _contains(Float item) {
        for (float value : this.source) {
            if (Objects.equals(value, item))
                return true;
        }
        return false;
    }

    @Override
    public void _copyTo(Object[] array, int arrayIndex) {
        for (float item : this.source)
            array[arrayIndex++] = item;
    }

    @Override
    public Float[] _toArray(Class<Float> clazz) {
        int length = this.source.length;
        Float[] array = ArrayUtils.newInstance(clazz, length);
        for (int i = 0; i < length; i++)
            array[i] = this.source[i];
        return array;
    }

    @Override
    public Object[] _toArray() {
        int length = this.source.length;
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++)
            array[i] = this.source[i];
        return array;
    }

    @Override
    public List<Float> _toList() {
        int length = this.source.length;
        List<Float> list = new ArrayList<>(length);
        for (float item : this.source)
            list.add(item);
        return list;
    }
}