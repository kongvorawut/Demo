package com.example.demoappfornewjoiner.repo

import com.example.demoappfornewjoiner.model.Cat
import io.reactivex.Observable

interface Repository {
	fun randomCat(): Observable<Cat>
}