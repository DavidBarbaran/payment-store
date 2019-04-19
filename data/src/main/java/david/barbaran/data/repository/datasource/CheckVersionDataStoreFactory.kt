package david.barbaran.data.repository.datasource

class CheckVersionDataStoreFactory {

    fun create() : CheckVersionDataStore{
        return CheckVersionCloudDataStore()
    }
}