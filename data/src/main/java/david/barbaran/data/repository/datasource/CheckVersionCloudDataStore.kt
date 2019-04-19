package david.barbaran.data.repository.datasource

import david.barbaran.data.connection.RestApi
import david.barbaran.domain.model.CheckVersion
import kotlinx.coroutines.Deferred

class CheckVersionCloudDataStore : CheckVersionDataStore {

    override fun checkVersion(): Deferred<CheckVersion> {
        return RestApi.instance().checkVersion()
    }
}