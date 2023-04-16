#adding current user to docker group
sudo apt update
sudo apt upgrade
sudo apt install openjdk-17-jdk openjdk-17-jre
sudo apt install docker.io
if ! [ $(getent group docker) ]; then
   sudo groupadd docker
   sudo usermod -aG docker ${USER}
   exec bash
fi
sudo chown "$USER":"$USER" /home/"$USER"/.docker -R
sudo touch $HOME/.docker
sudo chmod g+rwx "$HOME/.docker" -R
sudo chmod 666 /var/run/docker.sock
