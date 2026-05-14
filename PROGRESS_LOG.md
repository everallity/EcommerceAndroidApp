# Project Progress Log

This file tracks the features implemented, architectural decisions made, and the current status of the EcommerceAndroidApp (Shopee Clone).

## 🛠 Project Status Summary
- **Current Phase:** Feature Development (Auth & Catalog Integration)
- **Last Updated:** Current Session

---

## ✅ Completed Features / Infrastructure

### 1. Core Infrastructure
- **Dependency Injection:** Hilt integration fully set up with `NetworkModule`, `DataModule`, and `DataStoreModule`.
- **Networking (Dual-Backend):** Retrofit & OkHttp configured with **Qualifiers** (`@AuthRetrofit`, `@MainRetrofit`) to handle both `everallityshop` (Auth) and `TechShop` (Main) services.
- **Data Persistence:** `TokenManager` using DataStore for secure JWT storage.
- **Theming:** Material 3 Theme with Shopee-style colors (e.g., `#EE4D2D` orange).
- **Navigation:** `EcommerceNavGraph` implemented with `login_screen` and `catalog_screen` routes.
- **AI Context Integration:** Repository maps and AI Guidelines established for consistent development.

### 2. Authentication Feature (Full Stack)
- **Domain:** UseCases for `Login`, `SignUp`, and `GetAuthState` implemented.
- **Data:** `AuthenticationRepositoryImpl` handles token storage and validation against the `everallityshop` backend.
- **Mappers:** `AuthTokenMapper` and `AccountMapper` for DTO-to-Domain conversion.
- **Presentation:** `LoginScreen` with state-driven UI, error handling, and `AuthEvent` navigation.

### 3. Catalog Feature (Integration)
- **Data:** `ProductApi` and `ProductRepositoryImpl` implemented to fetch products from `TechShop`.
- **Presentation:** `CatalogScreen` with `ProductGridList` and detailed `ProductItemCard` styling (Shopee aesthetic).

### 4. Cart Feature (Infrastructure)
- **Data:** `CartApi` mapped with TechShop endpoints (including `@Multipart` and `@FormUrlEncoded`).
- **Domain/Presentation:** Base UseCases and `CartViewModel` structure ready.

---

## ⏳ In Progress
- [ ] **TopBar & BottomBar Logic:** Completing the `MainScreen` Scaffold to show/hide bars based on navigation state.
- [ ] **Cart Implementation:** Connecting the UI to the `CartApi` logic.
- [ ] **Product Detail Screen:** Navigating from the grid to a detailed view.

---

## 📋 Future Roadmap
- [ ] **Search & Filtering:** Adding search functionality to the Catalog.
- [ ] **Checkout Process:** Address selection and payment simulation.
- [ ] **User Profile:** Account details using the `AccountApi`.
- [ ] **Optimizations:** Image caching (Coil 3), Shimmer effects, and Offline support.

---

## 🧠 Architecture Decision Records (ADR)
- **Decision 1:** Use Feature-based packages. *Why?* Better scalability and code separation for mid-level portfolio.
- **Decision 2:** Dual-Retrofit Configuration. *Why?* Allows seamless communication with two distinct backends (Spring Boot Auth and JDBC Logic) within a single app.
- **Decision 3:** UseCases for every action. *Why?* To demonstrate Clean Architecture and keep business logic out of ViewModels, making them easier to test.
