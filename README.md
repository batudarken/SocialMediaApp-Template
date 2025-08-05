# SocialConnect - Android Sosyal Medya Uygulaması

## Proje Açıklaması

SocialConnect, Kotlin diliyle geliştirilmiş profesyonel bir Android sosyal medya uygulamasıdır. Clean Architecture prensipleri ve MVVM (Model-View-ViewModel) tasarım deseni kullanılarak geliştirilmiştir.

## Özellikler

### 📱 Temel Özellikler
- **Giriş Sayfası**: E-posta ve şifre ile güvenli giriş
- **Kayıt Sayfası**: Yeni kullanıcı kaydı ve sosyal medya entegrasyonu
- **E-posta Doğrulama**: 6 haneli kod ile e-posta doğrulama
- **Ana Sayfa**: Paylaşım akışı, hikayeler ve etkileşim özellikleri
- **Canlı Yayın**: Gerçek zamanlı video yayını (UI hazır, API entegrasyonu sonra)
- **Profil Sayfası**: Kullanıcı profili ve paylaşım yönetimi
- **Ayarlar**: Tema, bildirim ve hesap ayarları

### 🎨 Tasarım
- **Renk Teması**: Mavi tonları (#1E88E5) ana renk
- **Modern UI**: Material Design 3 bileşenleri
- **Responsive**: Mobil cihazlar için optimize edilmiş
- **Sade Tasarım**: Kullanıcı dostu arayüz

### 🏗️ Mimari
- **Clean Architecture**: Domain, Data ve Presentation katmanları
- **MVVM Pattern**: ViewModel ile veri yönetimi
- **Dependency Injection**: Hilt kullanımı
- **Repository Pattern**: Veri erişim katmanı
- **Use Cases**: İş mantığı ayrımı

## Teknolojiler

- **Kotlin**: Ana programlama dili
- **Android Jetpack**: Modern Android geliştirme bileşenleri
- **Material Design 3**: UI/UX tasarım sistemi
- **Hilt**: Dependency injection
- **ViewBinding**: Güvenli view erişimi
- **Coroutines**: Asenkron programlama
- **StateFlow**: Reaktif veri akışı

## Proje Yapısı

```
app/src/main/java/com/example/socialmediaapp/
├── data/                    # Veri katmanı
│   ├── model/              # Veri modelleri
│   ├── repository/         # Repository implementasyonları
│   └── source/             # Veri kaynakları
├── domain/                 # Domain katmanı
│   ├── model/              # Domain modelleri
│   ├── repository/         # Repository arayüzleri
│   └── usecase/            # Use case'ler
└── presentation/           # Presentation katmanı
    ├── ui/                 # Activity ve Fragment'lar
    │   └── adapter/        # RecyclerView adapter'ları
    └── viewmodel/          # ViewModel'lar
```

## Kurulum

1. **Projeyi klonlayın**:
   ```bash
   git clone [repository-url]
   cd social_media_app
   ```

2. **Android Studio'da açın**:
   - Android Studio'yu açın
   - "Open an existing project" seçin
   - Proje klasörünü seçin

3. **Gradle sync yapın**:
   - Android Studio otomatik olarak gradle sync başlatacaktır
   - Gerekli bağımlılıklar indirilecektir

4. **Uygulamayı çalıştırın**:
   - Emülatör veya fiziksel cihaz bağlayın
   - Run butonuna tıklayın

## Ekranlar

### 1. Giriş Sayfası
- E-posta ve şifre alanları
- "Giriş Yap" butonu
- "Şifremi Unuttum?" linki
- Kayıt sayfasına yönlendirme

### 2. Kayıt Sayfası
- Ad, soyad, e-posta, şifre alanları
- Sosyal medya giriş butonları (Google, Apple, Twitter, TikTok)
- Form validasyonu

### 3. E-posta Doğrulama
- 6 haneli kod girişi
- Geri sayım timer'ı
- Kod tekrar gönderme özelliği

### 4. Ana Sayfa
- Hikaye alanı (yatay scroll)
- Paylaşım akışı
- Like, yorum, paylaş butonları
- Yeni paylaşım butonu

### 5. Canlı Yayın
- Kamera önizlemesi
- Yayın başlatma/durdurma
- Canlı yorum sistemi
- Görüntüleyici sayacı

### 6. Profil Sayfası
- Profil bilgileri
- İstatistikler (paylaşım, takipçi, takip)
- Paylaşım grid'i
- Profil düzenleme

### 7. Ayarlar
- Hesap ayarları
- Bildirim tercihleri
- Tema seçimi
- Çıkış yapma

## Geliştirme Notları

### Dummy Özellikler
Aşağıdaki özellikler şu anda UI seviyesinde hazır, backend entegrasyonu sonra eklenecek:
- Sosyal medya girişleri
- Canlı yayın API'si
- Gerçek veri akışı
- Fotoğraf/video yükleme
- Push notification'lar

### Sonraki Adımlar
1. Backend API entegrasyonu
2. Gerçek veri modelleri
3. Resim/video yükleme
4. Push notification sistemi
5. Sosyal medya SDK entegrasyonları
6. Video streaming API entegrasyonu

## Katkıda Bulunma

1. Fork yapın
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için `LICENSE` dosyasına bakın.

## İletişim

Proje hakkında sorularınız için:
- E-posta: [email]
- GitHub: [github-profile]

---

**Not**: Bu uygulama eğitim amaçlı geliştirilmiştir. Üretim ortamında kullanmadan önce güvenlik ve performans testlerini tamamlayın.

