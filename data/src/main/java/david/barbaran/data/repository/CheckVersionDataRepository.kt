package david.barbaran.data.repository

import david.barbaran.data.repository.datasource.CheckVersionDataStoreFactory
import david.barbaran.domain.model.CheckVersion
import david.barbaran.domain.repository.CheckVersionRepository
import kotlinx.coroutines.*

class CheckVersionDataRepository : CheckVersionRepository{

    private val factory = CheckVersionDataStoreFactory()

    override suspend fun checkVersion(): Deferred<CheckVersion> {
        return factory.create().checkVersion()
    }

}