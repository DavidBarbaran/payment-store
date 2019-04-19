package david.barbaran.data.repository.datasource

import david.barbaran.domain.model.CheckVersion
import kotlinx.coroutines.Deferred

interface CheckVersionDataStore {
    fun checkVersion(): Deferred<CheckVersion>
}