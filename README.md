
## How to Run the Application

Follow these steps to set up and run the application:

1. **Clone the repository**  
   Run the following command to clone the repository to your local machine:
   ```bash
   git clone <URL_REPOSITORY>
2. **Navigate to project directory**
   ```bash
   cd project-name
3. **Run the app**
   
   On Linux:
   ```bash
   ./gradelw run
   ```
  
   On Windows:
   ```bash
   gradlew.bat run
   ```
   
# Dependency(Module : app)
```kotlin
    plugins {
    id("com.google.gms.google-services")
}
dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-storage-ktx")
}

```

# Model
1. **`Workout`**
```kotlin
data class workout(
    val name: String,
    val duration: Int,
    val calories: Int,
    val description: String
)
```
`Workout` memiliki empat properti utama:  

- `name` (String): Nama dari workout.  
- `duration` (Int): Durasi workout dalam menit.  
- `calories` (Int): Jumlah kalori yang terbakar selama workout.  
- `description` (String): Deskripsi singkat tentang workout.  

## Example usage 
```kotlin
val yoga = Workout(
    name = "Yoga",
    duration = 60,
    calories = 250,
    description = "Latihan yoga untuk relaksasi dan fleksibilitas."
)
```
## Dummy Datas
```kotlin
val workouts = listOf(
    workout(
        name = "Running",
        duration = 30,
        calories = 300,
        description = "A morning run to improve stamina and burn calories."
    ),
    workout(
        name = "Yoga",
        duration = 45,
        calories = 150,
        description = "A relaxing yoga session to improve flexibility and mindfulness."
    ),
    workout(
        name = "Cycling",
        duration = 60,
        calories = 500,
        description = "An outdoor cycling session for cardio and lower body strength."
    ),
    workout(
        name = "Weightlifting",
        duration = 40,
        calories = 250,
        description = "Strength training with weights for muscle building."
    ),
    workout(
        name = "Swimming",
        duration = 50,
        calories = 400,
        description = "Full-body workout for cardio and muscle endurance."
    ),
    workout(
        name = "Jogging",
        duration = 40,
        calories = 350,
        description = "Jogging "
    )
)
```
# Firebase Initialization

`FirebaseApp.initializeApp(this)` digunakan untuk menginisialisasi Firebase di sebuah aplikasi Android.

## Code Implementation
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
    }
}
```
# Firebase Authentication

**Firebase Authentication** adalah layanan yang disediakan oleh Firebase untuk mengelola autentikasi pengguna. Layanan ini mendukung berbagai metode autentikasi, seperti email dan password, Google, Facebook, dan lainnya, serta menyediakan integrasi yang mudah dengan aplikasi Android, iOS, dan web.

---

## Features

- **Multi-Platform Support**: Digunakan di Android, iOS, dan Web.
- **Beragam Metode Autentikasi**: Mendukung email/password, nomor telepon, penyedia pihak ketiga (Google, Facebook, Twitter), dan lainnya.
- **Integrasi Sederhana**: Mudah diintegrasikan dengan Firebase Firestore, Realtime Database, dan layanan lainnya.

---

## Instalasi dan Konfigurasi

1. **Tambahkan Dependensi:**
   Tambahkan Firebase Authentication ke dalam proyek Anda:
   ```gradle
   implementation 'com.google.firebase:firebase-auth-ktx'

## Firebase Authentication: Register User 
Kode ini digunakan untuk mendaftarkan pengguna baru dengan Firebase Authentication menggunakan email dan password. Jika proses pendaftaran berhasil, pengguna akan diarahkan ke layar login.
### Code Implementation
```kotlin
val auth = FirebaseAuth.getInstance()
if (email.isBlank() || password.isBlank()) {
    Toast.makeText(
        context,
        "Email or password cannot be empty",
        Toast.LENGTH_SHORT
    ).show()
} else {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(
                    context,
                    "Login Successful!",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(com.example.jetpckcompose.LoginScreen)
            } else {
                Toast.makeText(
                    context,
                    "Error: ${task.exception?.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}
```
## Firebase Authentication: Sign In User

Kode ini digunakan untuk mengautentikasi pengguna dengan Firebase Authentication menggunakan email dan password. Jika autentikasi berhasil, pengguna akan diarahkan ke layar utama aplikasi.

### Code Implementation
```kotlin
val auth = FirebaseAuth.getInstance()
if (email.isBlank() || password.isBlank()) {
    Toast.makeText(
        context,
        "Email or password cannot be empty",
        Toast.LENGTH_SHORT
    ).show()
} else {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(
                    context,
                    "Registration Successful!",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(com.example.jetpckcompose.HomeScreen)
            } else {
                Toast.makeText(
                    context,
                    "Error: ${task.exception?.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}
```
# Firebase Firestore

**Firebase Firestore** adalah layanan database NoSQL yang disediakan oleh Firebase, dirancang untuk menyimpan, menyinkronkan, dan mengelola data aplikasi Anda secara real-time di cloud.

## Features

- **NoSQL Database**: Menyimpan data dalam bentuk dokumen (JSON-like), yang dikelompokkan ke dalam koleksi.
- **Real-time Updates**: Data akan diperbarui secara otomatis di semua perangkat yang terhubung.
- **Query yang Fleksibel**: Mendukung berbagai filter, sorting, dan kombinasi data.
- **Skalabilitas Tinggi**: Cocok untuk aplikasi dengan jumlah pengguna kecil hingga besar.

## Instalasi

1. Tambahkan dependensi Firestore ke dalam file `build.gradle`:
   ```gradle
   implementation 'com.google.firebase:firebase-firestore-ktx'

# Implementation
## Add Workout Button with Firebase Firestore

Kode ini menambahkan tombol untuk menyimpan data workout ke dalam koleksi `workouts` di Firebase Firestore.

### Code Implementation
```kotlin
Button(
    modifier = Modifier.fillMaxWidth(),
    colors = ButtonDefaults.buttonColors(
        containerColor = colorResource(R.color.greengacor),
        contentColor = Color.White
    ),
    onClick = {
        val db = FirebaseFirestore.getInstance()
        workouts.forEach { workout ->
            db.collection("workouts")
                .add(workout)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(
                        context,
                        "Workout added: ${documentReference.id}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(
                        context,
                        "Error adding workout: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }
) {
    Text("Add Workout")
}
```
# WorkoutViewModel: Fetch Workouts from Firestore

**WorkoutViewModel** digunakan untuk mengelola data workout dengan memanfaatkan Firebase Firestore sebagai sumber data dan menggunakan `StateFlow` untuk menyediakan data secara reaktif.
## Code Implementation
```kotlin
class WorkoutViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _workouts = MutableStateFlow<List<workout>>(emptyList())
    val workouts: StateFlow<List<workout>> get() = _workouts

    init {
        fetchWorkouts()
    }

    private fun fetchWorkouts() {
        db.collection("workouts")
            .get()
            .addOnSuccessListener { result ->
                val workoutList = result.documents.mapNotNull { document ->
                    document.toObject(workout::class.java)
                }
                _workouts.value = workoutList
            }
            .addOnFailureListener { e ->
            }
    }
}
```
# Firebase Authentication & FireStore Data
![image](https://github.com/user-attachments/assets/790e3f89-f656-40f4-bc45-71ddf1951631)
![image](https://github.com/user-attachments/assets/6f2e8d06-024f-4c9c-a58f-86fa94a43a58)
