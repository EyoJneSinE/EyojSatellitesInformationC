package com.eniskaner.eyojsatellitesinformation.core.data

interface Mapper<in I, out O> {
    fun map(input: I): O
}
