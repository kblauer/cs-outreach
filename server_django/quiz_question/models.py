from django.db import models
from quiz.models import Quiz

# Creates a model for the quiz question item.  It essentially
# creates the schema in the database for the quiz question item,
# including all fields and types.  This represents each question in a quiz,
# which encompasses the question text, type, and priority
class QuizQuestion(models.Model):
    # the survey this question corresponds to
    quiz = models.ForeignKey(Quiz)
    questionName = models.CharField(max_length=50)
    questionDescription = models.TextField()
    questionType = models.CharField(max_length=10)
    priority = models.IntegerField(default=0)
    createTime = models.DateTimeField(auto_now_add=True)
    updateTime = models.DateTimeField(auto_now=True)
    
    def __unicode__(self):
        return self.questionName