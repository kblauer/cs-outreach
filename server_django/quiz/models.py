from django.db import models

# Creates a model for the quiz item.  It essentially
# creates the schema in the database for the quiz item,
# including all fields and types.  This represents the quiz as a whole,
# not individual questions or responses.
class Quiz(models.Model):
    # Django already puts an ID in each model, which is why it's not here.
    quizName = models.CharField(max_length=50)
    quizDescription = models.TextField()
    quizType = models.CharField(max_length=10)
    createTime = models.DateTimeField(auto_now_add=True)
    updateTime = models.DateTimeField(auto_now=True)
    
    def __unicode__(self):
        return self.quizName