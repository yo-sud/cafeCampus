# CafeCampus - Proyecto Base Fase 1

## Descripción
Aplicación Android para la cafetería del campus (CafeCampus) que permite a estudiantes y administradores gestionar pedidos, menús y seguimiento de estados. La aplicación utiliza arquitectura MVVM + Repository con persistencia local Room.

## Arquitectura
El proyecto sigue la arquitectura **MVVM + Repository**:

```
VIEW (Composables) → ViewModel → CafeRepository (interface) → CafeRepositoryRoom → DAO → Room / SQLite
```

### Capas
1. **UI**: Composables de Jetpack Compose que muestran la interfaz y envían eventos
2. **ViewModel**: Gestiona el estado y expone Flows; depende de `CafeRepository` (interfaz)
3. **Repository**: Define el contrato de datos; `CafeRepositoryRoom` es la implementación con Room
4. **DAO**: Acceso a base de datos mediante anotaciones SQL
5. **Room**: Persistencia local en SQLite

## Estructura de Carpetas

```
com.tecsup.cafecampus/
├── data/
│   ├── local/
│   │   ├── entity/        # Entidades Room (Producto, etc.)
│   │   ├── dao/           # Data Access Objects
│   │   ├── CafeDatabase.kt
│   │   └── DatosIniciales.kt
│   └── repository/
│       ├── CafeRepository.kt   # Interfaz
│       └── CafeRepositoryRoom.kt # Implementación Room
├── model/
│   ├── Rol.kt                # Enum: ESTUDIANTE, ADMINISTRADOR
│   ├── EstadoPedido.kt       # Enum: RECIBIDO, PREPARANDO, LISTO, ENTREGADO, CANCELADO
│   └── ItemCarrito.kt
├── viewmodel/
│   ├── MenuViewModel.kt
│   ├── SesionViewModel.kt
│   └── ...
├── ui/
│   ├── theme/
│   │   ├── Color.kt          # Colores por perfil (naranja cliente, índigo admin)
│   │   ├── Type.kt
│   │   └── Theme.kt
│   ├── components/           # Componentes reutilizables
│   │   ├── AppTopBar.kt
│   │   ├── CafeButton.kt
│   │   ├── CafeTextField.kt
│   │   ├── ProductoCard.kt
│   │   └── EstadoChip.kt
│   ├── navigation/
│   │   ├── Rutas.kt          # Constantes de navegación
│   │   └── NavCafe.kt        # NavHost con destinos
│   ├── cliente/
│   │   ├── SplashScreen.kt
│   │   └── MenuScreen.kt
│   └── admin/
│       ├── PanelScreen.kt
│       └── ...
├── data/local/prefs/         # DataStore para preferencias
└── model/                    # Modelos de dominio
```

## Dependencias

Versiones clave del proyecto:
- **Room**: 2.6.1
- **Compose**: 2024.09.00 (BOM)
- **Navigation Compose**: 2.8.2
- **Lifecycle**: 2.8.6
- **DataStore**: 1.1.1
- **Kotlin**: 2.0.21
- **KSP**: 2.0.21-1.0.28

## Pasos de la Fase 1

El proyecto base incluye los pasos 0-12 de la guía del laboratorio. Para comenzar:

1. **Paso 0**: Repositorio configurado (este commit)
2. **Paso 1-2**: Entidades y DAOs completados
3. **Paso 3**: Repository con interfaz e implementación Room
4. **Paso 4**: Base de datos y datos iniciales
5. **Paso 5-6**: ViewModels y navegación básica
6. **Paso 7-8**: Pantallas de cliente (Splash, Menú, Perfil)
7. **Paso 9-10**: Pantallas de administrador (Panel, Gestión de productos)
8. **Paso 11-12**: Carrito de compras, pedidos y estados
9. **Paso 13**: Tests y cierre

## Requisitos para Ejecutar

1. Android Studio 2024.2.2 (or later)
2. Kotlin 2.0.21+
3. SDK mínimo: 24 (Android 7.0)
4. SDK target: 34

## Primeros Pasos

```bash
# 1. Sincronizar Gradle
# 2. Ejecutar en emulador o dispositivo físico
# 3. La app iniciará en SplashScreen
# 4. Navegar al menú para ver los 6 productos iniciales
```

## Próximos Entregables

- Commit 1: Estructura base (✅ realizado)
- Commit 2-3: Entidades y DAOs
- Commit 4-5: Repository e implementación
- Commit 6: Base de datos y DAOs adicionales
- Commit 7-8: ViewModels iniciales
- Commit 9-10: Pantallas de cliente
- Commit 11-12: Pantallas de administrador
- Commit 13: Cierre y pruebas

## Perfiles de Usuario

- **Estudiante**: Consulta menú, agrega al carrito, confirma pedidos, sigue estado
- **Administrador**: Gestión de menú, pedidos, cambio de estados, ventas del día

## Notas de Desarrollo

- El Repository es una **interfaz** para permitir futura conexión a servidor
- Las lecturas usan `Flow`; las escrituras usan `suspend` functions
- Los colores varían según el perfil (naranja para cliente, índigo para admin)
- La base comparte datos entre perfiles en el mismo dispositivo