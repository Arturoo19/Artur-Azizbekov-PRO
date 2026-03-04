import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenPizza',
  standalone: false,
})
export class ImagenPizzaPipe implements PipeTransform {

  transform(value: string): string {

    switch (value?.toLowerCase()) {

      case 'barbacoa':
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSALhRXZWLqbz0CjyoiAAsWWPLEnCrUY114Bw&s';

      case 'hawaiana':
        return 'https://img.icons8.com/color/1200/medium-priority.jpg';

      case 'jamon y queso':
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnKYoeK-Qo2xTgTYITWqLbmriXi-QhhjVA-Q&s';

      default:
        return 'https://t4.ftcdn.net/jpg/16/71/95/89/360_F_1671958984_wi1gDwRJ4UgT0tpjmp6BpHujKzbaAGI7.jpg';
    }
  }

}
