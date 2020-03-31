from pandas import DataFrame
import matplotlib.pyplot as plt
   
Data = {'Genres': ['Action', 'Adventure', 'Animation', 'Children', 'Comedy', 'Crime', 'Documentary', 'Drama', 'Fantasy', 'Film-Noir', 'Horror', 'IMAX', 'Musical', 'Mystery', 'Romance', 'Sci-Fi', 'Thriller', 'War', 'Western'],
        'Movies Classified': [1828, 1263, 611, 664, 3756, 1199, 440, 4361, 779, 87, 978, 158, 334, 573, 1596, 980, 1894, 382, 167]
       }
  
df = DataFrame(Data,columns=['Genres','Movies Classified'])
df.plot(x ='Genres', y='Movies Classified', kind = 'bar')
plt.show()
