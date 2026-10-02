# WeatherApp
Project to display the weather in your current zone.

## Configuración de claves

Las claves no van en el código. Gradle las lee de `secrets.properties` (no se versiona) y las inyecta en `BuildConfig`.

1. Crea una cuenta gratuita en [Weatherstack](https://weatherstack.com/signup/free) y copia el access key del [panel](https://weatherstack.com/dashboard).
2. Si vas a usar Mapbox, crea los tokens en [account.mapbox.com/access-tokens](https://account.mapbox.com/access-tokens/). El token de descargas (`downloads:read`) es el de Gradle; el token público es el de la app.
3. Copia la plantilla y pega tus valores:

```bash
cp secrets.properties.example secrets.properties
```

4. No subas `secrets.properties`. Ya está en `.gitignore`.

| Propiedad | Dónde se usa |
| --- | --- |
| `WEATHERSTACK_ACCESS_KEY` | Módulo `remoteDataSource` (`BuildConfig.WEATHERSTACK_ACCESS_KEY`) |
| `MAPBOX_TOKEN` | Módulo `app` (`BuildConfig.MAPBOX_TOKEN`) |
| `MAPBOX_DOWNLOADS_TOKEN` | `settings.gradle.kts` (antes estaba como placeholder en `gradle.properties`) |
