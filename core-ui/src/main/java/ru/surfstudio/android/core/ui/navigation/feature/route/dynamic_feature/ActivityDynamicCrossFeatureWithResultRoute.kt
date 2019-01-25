/*
  Copyright (c) 2018-present, SurfStudio LLC, Maxim Tuev.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
@file:Suppress("unused")

package ru.surfstudio.android.core.ui.navigation.feature.route.dynamic_feature

import android.content.Intent
import ru.surfstudio.android.core.ui.event.result.SupportOnActivityResultRoute
import java.io.Serializable

/**
 * Dynamic Feature navigation Activity route with support of Activity result delivering.
 *
 * Designed for navigation to Activity from separate Dynamic Feature, doesn't matter installed or
 * not at the present moment.
 *
 * @param T result type (should be [Serializable])
 *
 * @see [DynamicCrossFeatureRoute]
 * @see [ActivityDynamicCrossFeatureRoute]
 */
abstract class ActivityDynamicCrossFeatureWithResultRoute<T : Serializable> :
        ActivityDynamicCrossFeatureRoute(),
        SupportOnActivityResultRoute<T> {

    override fun prepareResultIntent(resultData: T): Intent {
        val i = Intent()
        i.putExtra(SupportOnActivityResultRoute.EXTRA_RESULT, resultData)
        return i
    }

    override fun parseResultIntent(resultIntent: Intent): T {
        @Suppress("UNCHECKED_CAST")
        return resultIntent.getSerializableExtra(SupportOnActivityResultRoute.EXTRA_RESULT) as T
    }

    override fun getRequestCode(): Int {
        return Math.abs(this.javaClass.canonicalName!!.hashCode() % MAX_REQUEST_CODE)
    }

}

private const val MAX_REQUEST_CODE = 32768