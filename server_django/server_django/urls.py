"""server_django URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.8/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import include, url
from django.contrib import admin

# These patterns generate how the URL structure of the overall site will work.  
# All URL's route through this particular page, always.  
# This particular page acts as a controller for the rest of the URL's, 
# sending each request to the correct app

urlpatterns = [
    url(r'^admin/', include(admin.site.urls)),
    
    # *** User Authorization URL patterns ***
    # this includes the browser-side parsing of the login data (/auth),
    # the logout request (/request),
    # the successful login redirect (/success), 
    # and the page reached if invalid login information is sent (/invalid).
    url(r'^user/auth/$', 'surveyor.views.auth_view'),
    url(r'^user/logout/$', 'surveyor.views.logout'),
    url(r'^user/success/$', 'surveyor.views.success'),
    url(r'^user/invalid/$', 'surveyor.views.invalid_login'),
]
