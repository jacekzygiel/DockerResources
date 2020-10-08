FROM python

ARG git_branch_name
ENV branch_name=$git_branch_name
RUN git clone https://github.com/jacekzygiel/docker_training_flask.git

WORKDIR /docker_training_flask

RUN git checkout ${branch_name}

RUN pip install -r requirements.txt

EXPOSE 5000

ENTRYPOINT [ "python" ]
CMD [ "app.py" ]