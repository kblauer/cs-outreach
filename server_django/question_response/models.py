from django.db import models
from quiz_question.models import QuizQuestion
from django.contrib.auth.models import User

# Creates a model for the question response item.  It contains a single response to
# a single question in a quiz, as well as the user who made the response.
class QuestionResponse(models.Model):
    question = models.ForeignKey(QuizQuestion)
    response = models.CharField(max_length=50)
    user = models.ForeignKey(User)
    createTime = models.DateTimeField(auto_now_add=True)
    updateTime = models.DateTimeField(auto_now=True)
    
    def __unicode__(self):
        return self.response