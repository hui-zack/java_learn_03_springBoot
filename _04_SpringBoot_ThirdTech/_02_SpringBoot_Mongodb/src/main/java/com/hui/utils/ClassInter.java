package com.hui.utils;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 函数式接口，实现Serializable, 获取序列化能力
 */
public interface ClassInter<T, R> extends Function<T, R>, Serializable {
}
