package com.techguys.shaadiapptest.di.scopes

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import javax.inject.Singleton


@Scope
@Retention(RetentionPolicy.RUNTIME)
@Singleton
annotation class AppScope

