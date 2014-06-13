beans = {
   localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
      defaultLocale = new Locale("es","ES")
      java.util.Locale.setDefault(defaultLocale)
   }
}