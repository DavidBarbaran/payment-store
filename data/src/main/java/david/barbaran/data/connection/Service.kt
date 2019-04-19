package david.barbaran.data.connection

import david.barbaran.domain.model.CheckVersion
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Service {

    @GET("checkVersion.json")
    fun checkVersion(): Deferred<CheckVersion>
}