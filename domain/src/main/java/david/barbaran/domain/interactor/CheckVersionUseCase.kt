package david.barbaran.domain.interactor

import david.barbaran.domain.model.CheckVersion
import david.barbaran.domain.repository.CheckVersionRepository
import kotlinx.coroutines.Deferred

class CheckVersionUseCase (private val checkVersionRepository: CheckVersionRepository){

    suspend fun checkVersion() : Deferred<CheckVersion>{
        return checkVersionRepository.checkVersion()
    }
}