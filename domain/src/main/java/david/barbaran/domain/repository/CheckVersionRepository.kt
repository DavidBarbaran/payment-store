package david.barbaran.domain.repository

import david.barbaran.domain.model.CheckVersion
import kotlinx.coroutines.Deferred

interface CheckVersionRepository {

    suspend fun checkVersion(): Deferred<CheckVersion>
}