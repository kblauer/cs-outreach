# cs-outreach.views -- contains site wide, app-independent views such as login
# and index.  All other views for site are placed in individual apps,
# which are essentially just directories.  This is the top-level views file.  
# it belongs to no app.  This means that it's specific to cs-outreach, and not modular.

from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from django.contrib import auth
from django.core.context_processors import csrf

# This is the Home view, it gets called when the index.html page is requested.  
# All it needs is a username context to fill, if the current user is logged in.
# If they are not, this is None and we can instead prompt the user to login.
def home(request):
    username = None
    
    if request.user.is_authenticated():
        username = request.user.username
    
    args = {}
    args.update(csrf(request))
    
    args['username'] = username
    
    return render_to_response('index.html', args)
    
    # This is the old, insecure way that we were doing this.
    # Keeping it for reference in order to not make the same mistakes
    #return render_to_response('index.html', 
    #                          {'username' : username},
    #                          context_instance=RequestContext(request))


# *** Begin User authentication views *** 
# These views will deal with each of the URL patterns for user login/logout
def auth_view(request):
    username = request.POST.get('username', '')
    password = request.POST.get('password', '')
    
    # query the user database, return either a user object or None
    user = auth.authenticate(username=username, password=password)
    
    if user is not None:
        auth.login(request, user)
        return HttpResponseRedirect('/user/success/')
    else:
        return HttpResponseRedirect('/user/invalid/')
    
def success (request):
    return render_to_response('success.html',
                              {'full_name': request.user.username})
    
def invalid_login(request):
    return render_to_response('invalid_login.html')

def logout(request):
    auth.logout(request)
    return HttpResponseRedirect('/')