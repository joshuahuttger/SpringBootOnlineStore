#adding current user to docker group
if ! [ $(getent group docker) ]; then
   sudo groupadd docker
   sudo usermod -aG docker ${USER}
   exec bash
fi
sudo chown "$USER":"$USER" /home/"$USER"/.docker -R
sudo chmod g+rwx "$HOME/.docker" -R
sudo chmod 666 /var/run/docker.sock
alias prod="cd /home/josh/Documents/spring-workspace/SpringBootOnlineStore"
